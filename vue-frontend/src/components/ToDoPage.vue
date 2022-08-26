<template>
  <div class="container">
    <div>
      <ToDoItem
        v-for="item in store.state.toDoList"
        :key="item.id"
      >
        <template v-slot:title>
          {{ item.title }}
        </template>
        <template v-slot:completed>
          <input
            type="checkbox"
            :checked="item.completed"
          />
        </template>
      </ToDoItem>
    </div>
    <button>Add Task</button>
  </div>
</template>

<script>
import ToDoItem from "./ToDoItem.vue";
import { store } from "../store/store";
export default {
  name: "ToDo",
  components: {
    ToDoItem,
  },
  methods: {},
  setup() {
    return {
      store,
    };
  },
};
</script>

<style scoped></style>
