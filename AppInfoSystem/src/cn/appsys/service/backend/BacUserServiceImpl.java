package cn.appsys.service.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.tools.ResultData;

@Service
public class BacUserServiceImpl implements BacUserService {
	@Autowired
	private BackendUserMapper backendUserMapper;

	@Override
	public ResultData selectDevUserByCode(String devcode, String devpassword) {
		ResultData rd = new ResultData();
		if (devcode != null && devcode != "") {
			BackendUser user = backendUserMapper.selectDevUserByCode(devcode);
			if (user != null) {
				if (user.getUserpassword().equals(devpassword)) {
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
