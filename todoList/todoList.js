//https://freshman.tech/todo-list/
//https://freshman-todo.surge.sh/
const list = document.getElementById("list");
const input = document.getElementById("input");

//Class names
const CHECK = "fa-check-circle";
const UNCHECK = "fa-circle-thin";
const LINE_THROUGH = "lineThrough";


function addToDo(todo, done) {

	const DONE = done ? CHECK : UNCHECK;
	const LINE = done ? LINE_THROUGH : "";

	const item = `<li class="item">
	<i class="fa ${DONE} co" job="complete"></i>
	<p class="text ${LINE}">${todo}</p>
	<i class="fa fa-trash-o de" job="delete"></i>
	</li>`;
	const position = "beforeend";
	list.insertAdjacentHTML(position, item);

}

document.addEventListener("keyup", function(event) {
	
	if (event.keyCode == 13) {
		const todo = input.value;
		if (todo) {
			addToDo(todo, false);
		}
		input.value="";
	}
});


list.addEventListener("click", function(event) {
	const element = event.target;
	const elementJob = element.attributes.job.value;

	if (elementJob == "complete") {
		completeToDo(element);
	} else if (elementJob == "delete"){
		deleteToDo(element);
	}
})

function completeToDo(element) {
	element.classList.toggle(CHECK);
	element.classList.toggle(UNCHECK);
	element.parentNode.querySelector(".text").classList.toggle(LINE_THROUGH);
}

function deleteToDo(element) {
    element.parentNode.parentNode.removeChild(element.parentNode);
}