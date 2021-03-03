package c0720g1be.repository;

import c0720g1be.dto.IMemberInfDTO;
import c0720g1be.entity.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {

    Page<UserGroup> findAllByNameContaining(String name, Pageable pageable);


    @Transactional
    @Query(value = "select count(*) as dem \n" +
            " from account_group\n" +
            " where group_id = ?1\n" +
            " group by group_id", nativeQuery = true)
    int memberQuantity(int groupId);

    @Transactional
    @Query(value = "select count(*) as dem \n" +
            " from account_group\n" +
            " group by group_id", nativeQuery = true)
    List<Integer> listMemberQuantity();

    @Transactional
    @Query(value = "select count(*) as dem \n" +
            "from post\n" +
            "where group_id = ?1\n" +
            "group by group_id ", nativeQuery = true)
    Integer postGroupQuantity(int groupId);

    @Transactional
    @Query(value = "select a.id , a.avatar , a.background_image " +
            "from `account` a " +
            "right join account_group abc on abc.account_id = a.id "+
            "where abc.group_id = ?1", nativeQuery = true)
    Page<IMemberInfDTO> getListMember(Integer groupId, Pageable pageable);

}
