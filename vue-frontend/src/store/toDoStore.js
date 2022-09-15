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
  },
  actions: {
    async fetch(ctx) {
      const res = await (
        await ToDoService.getToDoList()
      ).data;
      ctx.commit("setToDoList", res);
    },
    async addItem(ctx, toDoItem) {
      const post = await ToDoService.addToDo(toDoItem);
      ctx.commit("setToDoList", post);
    },
    async updateItem(ctx, toDoId) {
      const update = await ToDoService.updateToDo(
        toDoId.id
      );
      ctx.commit("setToDoList", update);
    },
  },
};
