import ToDoService from "../services/ToDoService";
export const toDoList = {
  namespaced: true,
  state() {
    return { all: [] };
  },
  mutations: {
    setToDoList(state, toDoList) {
      state.all = toDoList;
    },
    addToDoItem(state, toDoItem) {
      state.all.push({
        id: state.all.length,
        title: toDoItem,
        completed: false,
      });
    },
  },
  actions: {
    async fetch(ctx) {
      const res = await (
        await ToDoService.getToDoList()
      ).data;
      ctx.commit("setToDoList", res);
    },
    async addItem(ctx) {
      const res = "new item added";
      ctx.commit("addToDoItem", res);
    },
  },
};
