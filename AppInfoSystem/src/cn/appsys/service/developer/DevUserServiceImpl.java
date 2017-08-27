package cn.appsys.service.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.tools.ResultData;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Autowired
	private DevUserMapper devUserMapper;

	@Override
	public ResultData selectDevUserByCode(String devCode, String devpassword) {
		ResultData rd = new ResultData();
		if (devCode != null && devCode != "") {
			DevUser user = devUserMapper.selectDevUserByCode(devCode);
			if (user != null) {
				if (user.getDevpassword().equals(devpassword)) {
					rd.setFlag(0);
					rd.setMsg("登录成功");
					rd.setData(user);
				} else {
					rd.setFlag(1);
					rd.setMsg("密码错误,请重新输入");
				}
			} else {
				rd.setFlag(2);
				rd.setMsg("查无此人,请重新输入用户名");
			}
		} else {
			rd.setFlag(3);
			rd.setMsg("用户名不能为空");
		}

		return rd;
	}
}
