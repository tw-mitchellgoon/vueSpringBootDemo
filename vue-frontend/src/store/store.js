import { toDoList } from "./toDoStore";
// import { toDoList } from "./testListStore";
import { createStore } from "vuex";

export const store = createStore({
  modules: { toDoList },
});
