import axios from "axios";

const apiBaseUrl =
  process.env.VUE_APP_TODO_API_BASE_URL;

class ToDoService {
  getToDoList() {
    return axios.get(`${apiBaseUrl}todolist`);
  }

  addToDo(toDoItem) {
    return axios
      .post(`${apiBaseUrl}todoadd`, toDoItem)
      .then((res) =>
        console.log(
          `Task created, Status Code: ${res.status}`
        )
      )
      .catch((err) => console.log(err));
  }

  updateToDo(toDoId) {
    return axios
      .get(`${apiBaseUrl}todoupdate/${toDoId}`)
      .then((res) => {
        console.log(
          `Task updated, Status returned: id: ${res.data.id}, ${res.data.title}, ${res.data.completed}`
        );
      });
  }
}

export default new ToDoService();
