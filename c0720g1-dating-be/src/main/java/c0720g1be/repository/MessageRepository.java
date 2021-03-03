package c0720g1be.repository;

import c0720g1be.dto.ChatDTO;
import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;
import c0720g1be.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface MessageRepository extends JpaRepository<Chat,Integer> {

    @Query(value = "SELECT * FROM chat  where box_id =?1 ORDER BY id  DESC LIMIT ?2", nativeQuery = true)
    List<Chat> listMessage(Integer box_id,Integer limit);


    @Modifying
    @Query(value = "insert into chat(sender,content,time_stamp,box_id,img_url)\n" +
            "values(?1, ?2, ?3, ?4, ?5);", nativeQuery = true)
    void addMessage(String sender,String content,String time_stamp, Integer box_id, String imgUrl);
}
