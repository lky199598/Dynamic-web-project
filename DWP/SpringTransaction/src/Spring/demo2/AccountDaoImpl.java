package Spring.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * 转帐案例的DAO层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	/**
	 * @param out:转出账号
	 * @param money：转出金额
	 */
	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money-? where name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}
	
	/**
	 * @param in：转入账号
	 * @param money：转账金额
	 */
	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money+? where name = ?";
		this.getJdbcTemplate().update(sql, money, in);

	}

}
