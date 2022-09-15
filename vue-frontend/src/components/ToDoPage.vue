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
            :onclick="toggleCompleted"
            :id="item.id"
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
        title: e.target.taskInput.value,
      });
      taskInput.value = "";
      setTimeout(() => {
        store.dispatch("toDoList/fetch");
      }, 100);
    };

    const toggleCompleted = (e) => {
      store.dispatch("toDoList/updateItem", {
        id: e.target.getAttribute("id"),
      });
      setTimeout(() => {
        store.dispatch("toDoList/fetch");
      }, 100);
    };

    return {
      toDoList,
      addItem,
      taskInput,
      toggleCompleted,
    };
  },
};
</script>

<style scoped></style>
