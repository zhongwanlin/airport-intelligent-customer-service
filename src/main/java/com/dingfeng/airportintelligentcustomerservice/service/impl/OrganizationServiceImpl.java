package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.OrganizationMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.OrganizationInfo;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.OrganizationInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.QueryOrganizationInput;
import com.dingfeng.airportintelligentcustomerservice.service.OrganizationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper orgMapper;

    @Override
    public PageInfo<OrganizationInfo> getList(QueryOrganizationInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<OrganizationInfo> organizationInfos = orgMapper.getList(query);
        return new PageInfo<>(organizationInfos);
    }

    @Override
    public Result getById(int id) {
        OrganizationInfo organizationInfo = orgMapper.getById(id);
        if (organizationInfo != null) {
            return Result.Success("查询成功", organizationInfo);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public Result add(OrganizationInput orgInput) {
        if (orgInput == null) {
            return Result.Error("参数为空");
        }
        if (orgMapper.exitOrganization(orgInput.getName(), 0) > 0) {
            return Result.Error("用户名" + orgInput.getName() + "已存在");
        }
        if (orgInput.getPid() > 0) {
            // 获取上级
            String fullname = "";
            int pid = orgInput.getPid();
            while (true) {
                OrganizationInfo org = orgMapper.getById(pid);
                if (org != null) {
                    if (fullname != "") {
                        fullname += "-" + org.getFullname();
                    } else {
                        fullname = org.getFullname();
                    }
                    pid = org.getPid();
                } else {
                    break;
                }
            }
            orgInput.setFullname(fullname);
        }

        if (orgMapper.add(orgInput) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(OrganizationInput orgInput) {
        if (orgInput == null) {
            return Result.Error("参数为空");
        }
        if (orgMapper.exitOrganization(orgInput.getName(), orgInput.getId()) > 0) {
            return Result.Error("部门名称" + orgInput.getName() + "已存在");
        }
        if (orgInput.getPid() > 0) {
            // 获取上级
            String fullname = "";
            int pid = orgInput.getPid();
            while (true) {
                OrganizationInfo org = orgMapper.getById(pid);
                if (org != null) {
                    if (fullname != "") {
                        fullname += "/" + org.getName();
                    } else {
                        fullname = org.getName();
                    }
                    pid = org.getPid();
                } else {
                    break;
                }
            }
            orgInput.setFullname(fullname + "/" + orgInput.getName());
        }

        if (orgMapper.edit(orgInput) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result disable(int id) {
        if (orgMapper.usedOrganization(id) > 0) {
            return Result.Error("该部门已有员工，不能禁用");
        }
        try {
            if (orgMapper.disable(id) > 0) {
                List<Integer> childIds = getOrgChildIds(id);
                for (int childId : childIds) {
                    if (orgMapper.usedOrganization(childId) > 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.Error("下级部门已有员工，不能删除");
                    }
                    orgMapper.disable(childId);
                }
                return Result.Success("禁用成功");
            }
        } catch (Exception e) {
            throw e;
        }

        return Result.Error("禁用失败，找不到部门信息");
    }

    private List<Integer> getOrgChildIds(int pid) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> childIds = orgMapper.getChildOrgIds(pid);
        if (childIds.size() > 0) {
            result.addAll(childIds);
            for (int childId : childIds) {
                result.addAll(getOrgChildIds(childId));
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result enable(int id) {
        try {
            if (orgMapper.enable(id) > 0) {
                List<Integer> childIds = getOrgChildIds(id);
                for (int childId : childIds) {
                    orgMapper.enable(childId);
                }
                return Result.Success("启用成功");
            }
        } catch (Exception e) {
            throw e;
        }
        return Result.Error("启用失败,找不到部门信息");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(int id) {
        if (orgMapper.usedOrganization(id) > 0) {
            return Result.Error("该部门已有员工，不能删除");
        }
        try {
            if (orgMapper.delete(id) > 0) {
                List<Integer> childIds = getOrgChildIds(id);
                for (int childId : childIds) {
                    if (orgMapper.usedOrganization(childId) > 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.Error("下级部门已有员工，不能删除");
                    }
                    orgMapper.delete(childId);
                }
                return Result.Success("删除成功");
            }
        } catch (Exception e) {
            throw e;
        }

        return Result.Error("删除失败，找不到部门信息");
    }

}
