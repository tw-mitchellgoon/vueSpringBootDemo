import { reactive } from "vue";
import { testList } from "./toDoStore";

class Store {
  constructor() {
    this.state = reactive({
      toDoList: testList,
    });
  }
}

export const store = new Store();
