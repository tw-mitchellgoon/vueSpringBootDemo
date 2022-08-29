<template>
  <div class="container">
    <div>
      <ToDoItem
        v-for="item in toDoList"
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
    <form @submit.prevent="addItem">
      <input
        type="text"
        name="taskInput"
        id="taskInput"
        v-model="taskInput"
      />

      <button>Add Task</button>
    </form>
  </div>
</template>

<script>
import ToDoItem from "./ToDoItem.vue";
import { useStore } from "vuex";

import { ref, computed, onMounted } from "vue";
export default {
  name: "ToDo",
  components: {
    ToDoItem,
  },

  setup() {
    const store = useStore();
    const taskInput = ref("");
    onMounted(() => {
      store.dispatch("toDoList/fetch");
    });
    const toDoList = computed(() => {
      return store.state.toDoList.all;
    });
    const addItem = (e) => {
      store.dispatch("toDoList/addItem", {
        toDoItem: e.target.taskInput.value,
      });
      taskInput.value = "";
    };

    return {
      toDoList,
      addItem,
      taskInput,
    };
  },
};
</script>

<style scoped></style>
