package com.share.ftp.handler.join;

import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class GroupUserUpdateHandler implements Command {

  GroupDao groupDao;

  public GroupUserUpdateHandler(GroupDao groupDao) {
    this.groupDao = groupDao;
  }

  // 마이페이지 나의 정보 수정 -> 비밀번호 입력시 변경가능
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[회원 변경]");

    String userPassword = Prompt.inputString("비밀번호? ");

    GroupDTO loginUser = groupDao.findByIdPassword(AuthLoginHandler.getLoginUser().getId(), userPassword);

    if (loginUser == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    String tel = Prompt.inputString("전화(" + loginUser.getTel() + ")? ");
    String email = Prompt.inputString("이메일(" + loginUser.getEmail() + ")? ");
    int postNo = Prompt.inputInt("우편번호(" + loginUser.getPostNo() + ")? ");
    String basicAddress = Prompt.inputString("기본주소(" + loginUser.getBasicAddress() + ")? ");
    String detailAddress = Prompt.inputString("상세주소(" + loginUser.getDetailAddress() + ")? ");
    int groupCount = Prompt.inputInt("소속인원(" + loginUser.getGroupCount()  + ")? ");
    String password = Prompt.inputString("암호? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    loginUser.setTel(tel);
    loginUser.setEmail(email);
    loginUser.setPostNo(postNo);
    loginUser.setBasicAddress(basicAddress);
    loginUser.setDetailAddress(detailAddress);
    loginUser.setGroupCount(groupCount);
    loginUser.setPassword(password);


    groupDao.update(loginUser);
    //    groupDao.updateGroup(loginUser);
    System.out.println("회원정보를 변경하였습니다.");
  }
}



