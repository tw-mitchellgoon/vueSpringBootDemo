import { toDoList } from "./toDoStore";
import { createStore } from "vuex";

export const store = createStore({
  modules: { toDoList },
});
