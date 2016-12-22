package Spring.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * ת�˰����Ĳ�����
 */

//ʹ��@RunWith(SpringJUnit4ClassRunner.class),�ò���������Spring���Ի���
//@ContextConfiguration ����ָ�����ص�Spring�����ļ���λ��,�����Ĭ�������ļ�

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo1 {
    
	//����ҵ������
	//@Resource:ʹ���ֶ�����ƥ��bean,���ҵ�bean��ע��,������Ͳ�ƥ�����ʱ���쳣,ע��ʧ�ܡ�
	@Resource(name="accountService")	
	private AccountService accountService;
	
	@Test
    public void demo1()
    {
    	accountService.transfer("aaa", "bbb", 200d);
    }
}