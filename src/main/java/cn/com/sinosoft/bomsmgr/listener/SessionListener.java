package cn.com.sinosoft.bomsmgr.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.bomsmgr.dao.BizExtLogMapper;
import cn.com.sinosoft.bomsmgr.entity.VisitParam;
import cn.com.sinosoft.tbf.dao.BaseDao;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Autowired
	BaseDao baseDao;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String today = sdf.format(new Date());
		BizExtLogMapper logMapper = getMapper();
		List<Integer> todayCount = logMapper.getVisitCount(today);
		if (todayCount == null || todayCount.size() == 0) {// 无今日访问量
			VisitParam params = new VisitParam();
			params.setCount(1);
			params.setDay(today);
			logMapper.insertVisitDay(params);
		} else {// 有今日访问量
			logMapper.addOneCount(today);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// do nothing
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private BizExtLogMapper getMapper() {
		return baseDao.getMapper(BizExtLogMapper.class);
	}

}
