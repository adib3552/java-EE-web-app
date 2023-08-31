import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Model.Student;

public class TestHib {
	public static void main(String[] args) {
		Student student=new Student("Potka","hentai@gmail.com","thicc123","43343");
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(student);
		
		tr.commit();
		
		session.close();
	}
}
