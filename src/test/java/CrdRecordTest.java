import dao.entity.CrdRecord;
import dao.mapper.CrdRecordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DELL on 2017-08-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-mybaits.xml"})
public class CrdRecordTest {
    @Autowired
    private CrdRecordMapper mapper;
    @Test
    public void testInsert() throws Exception {
        CrdRecord record = new CrdRecord();
        record.setUsrId(1002);
        record.setRecord("初始化评分");
        mapper.insert(record);
    }

    @Test
    public void testUpdate() {
        String newRecord = "增加10分";
        CrdRecord record = mapper.getUsrRecord(1001);
        record.setRecord(record.getRecord()+newRecord);
        mapper.update(record);

    }

    @Test
    public void testGet(){
        CrdRecord record= mapper.getUsrRecord(1001);
        System.out.println(record.getRecord());
    }
    @Test
    public void testDelete(){
        mapper.delete(1002);
    }

}
