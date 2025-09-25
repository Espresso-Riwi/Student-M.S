
package studentms;


public interface IRepository {
   void save(Student student);
   void findAll(); 
   void findById(String id);
   void delete(String id);
}
