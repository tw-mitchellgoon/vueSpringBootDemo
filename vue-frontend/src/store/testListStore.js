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
    fetch(ctx) {
      const list = [
        { id: 1, title: "Get Milk", completed: false },
        {
          id: 2,
          title: "Do SpringBoot Backend",
          completed: false,
        },
        { id: 3, title: "Fix Lamp", completed: true },
        {
          id: 4,
          title: "Clean Toilet",
          completed: false,
        },
        {
          id: 5,
          title:
            "Some other trivial task that doesn't really need to be on a to do list",
          completed: true,
        },
      ];

      ctx.commit("setToDoList", list);
    },
  },
};
