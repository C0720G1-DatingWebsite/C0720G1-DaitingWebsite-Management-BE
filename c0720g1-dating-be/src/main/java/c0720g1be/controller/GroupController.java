package c0720g1be.controller;

import c0720g1be.service.AccountGroupService;
import c0720g1be.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class GroupController {

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private AccountGroupService accountGroupService;

    @RequestMapping(value = "join-group/{idUser}/{idGroup}", method = RequestMethod.POST)
    public ResponseEntity<?> joinGroup(@PathVariable("idUser") int idUser,
                                       @PathVariable("idGroup") int idGroup) {
        this.accountGroupService.save(idUser, idGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "list-group", method = RequestMethod.GET)
    public ResponseEntity<?> listGroup(@PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(this.userGroupService.findAll(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "delete-group/{idGroup}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGroup(@PathVariable("idGroup") int idGroup) {
        this.userGroupService.deleteGroup(idGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "search-name-group/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> searchGroupByName(@PageableDefault(size = 5) Pageable pageable,
                                               @PathVariable("name") String name) {
        return new ResponseEntity<>(this.userGroupService.findByNameContaining(name, pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "get-group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<?> getGroup(@PathVariable("groupId") int groupId) {
        return new ResponseEntity<>(this.userGroupService.findGroupById(groupId), HttpStatus.OK);
    }

    @RequestMapping(value = "get-member-quantity/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMemberQuantity(@PathVariable("groupId") int groupId) {
        return new ResponseEntity<>(this.userGroupService.memberQuantity(groupId), HttpStatus.OK);
    }

    @RequestMapping(value = "get-list-member-quantity", method = RequestMethod.GET)
    public ResponseEntity<?> getListMemberQuantity() {
        return new ResponseEntity<>(this.userGroupService.listMemberQuantity(), HttpStatus.OK);
    }

    @RequestMapping(value = "get-post-group-quantity/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPostGroupQuantity(@PathVariable(name = "groupId") int groupId) {
        return new ResponseEntity<>(this.userGroupService.postGroupQuantity(groupId), HttpStatus.OK);
    }

    @RequestMapping(value = "list-member-group/{groupId}", method = RequestMethod.GET)
    public ResponseEntity<?> listMember(@PageableDefault(size = 5) Pageable pageable,
                                        @PathVariable int groupId) {
        return new ResponseEntity<>(this.userGroupService.getListMember(groupId,pageable), HttpStatus.OK);
    }
}
