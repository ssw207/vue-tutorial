import * as types from "./mutation-types";
import axios from "axios";
export default {
  //로그인
  login: ({ commit }, authInfo) => {
    console.log("로그인");
    commit(types.AUTH_LOGIN, {});
    return;
  },
  //로그아웃
  logout: ({ commit }, authInfo) => {
    console.log("로그아웃");
    commit(types.AUTH_LOGOUT, {});
  },
  //회원가입
  singUp: ({ commit }, authInfo) => {
    console.log("회원가입");
    commit(types.AUTH_LOGIN, {});
    return;
  },
  //모든리스트초회
  fechListes: ({ commit }, authInfo) => {
    console.log("모든리스트조회");
    commit(types.FETCH_ALL_TASKLIST, {});
    return;
  },
  //할일추가
  addTask: ({ commit }, authInfo) => {
    console.log("할일추가");
    commit(types.TASK_ADD, {});
    return;
  },
  //할일삭제
  deleteTask: ({ commit }, authInfo) => {
    console.log("할일삭제");
    commit(types.TASK_DELETE, {});
    return;
  },
  //할일수정
  updateTask: ({ commit }, authInfo) => {
    console.log("할일수정");
    commit(types.TASK_UPDATE, {});
    return;
  }
};
