function getRandomUsers(element) {
	var entries = prompt("How many users would you like?")
	fetch('https://randomuser.me/api/?gender=female&results='.concat(entries))
	.then(response => response.json())
	.then(data => {
	postUsersToApi(data.results)
	})
	.then(() => 
	getApiUsers(element));
}
function getApiUsers(element) {

	fetch('http://localhost:8080/contacts')
	.then(response => response.json())
	.then(data => {
	element.appendChild(createContactList(data));
	}
)
}
const registerNewContact = () => {
	event.preventDefault();
	console.log(event.target);
	const contact = document.createElement('p');
	const id = document.createElement('h2');
	id.textContent = crypto.randomUUID();
	contact.appendChild(id);
	for (let i = 0; i < event.target.length; i++){
		const attribute = document.createElement('h2');
		attribute.textContent = event.target[i].value;
		contact.appendChild(attribute);
	}
	postToServer(contact);
}
async function postToServer(user){
	var contact = {
		"id": user.children[0].textContent,
		"firstName": user.children[1].textContent,
		"lastName": user.children[2].textContent,
		"address": user.children[3].textContent,
		"phoneNumber": user.children[4].textContent
	,
	toJSON: function () {
		return {
			id: this.id,
			firstName: this.firstName,
			lastName: this.lastName,
			address: this.address,
			phoneNumber: this.phoneNumber
		}
	}
	}
	await fetch("http://localhost:8080/contacts", {
		method: "POST",
		headers: {'Content-Type': 'application/json',
				 'Accept': 'application/json'},
		body: JSON.stringify(contact)
	}).then(async rawResponse => {
		var content = await rawResponse.json();
	})
	.then(
		window.location.reload()
	);
	
}
function updateContact(contact){
	contact.firstName = prompt("Please enter new first name:", contact.firstName);
	contact.lastName = prompt("Please enter new last name:", contact.lastName);
	contact.address = prompt("Please enter new address", contact.address);
	contact.phoneNumber = prompt("Please enter new phone number:", contact.phoneNumber);
	console.log(contact);
	fetch("http://localhost:8080/contacts/".concat(contact.id), {
		method: "PUT",
		headers: {'Content-Type': 'application/json',
				 'Accept': 'application/json'},
		body: JSON.stringify(contact)
	})
	.then(
		window.location.reload()
	);
}
function deleteContact(contact){
	fetch("http://localhost:8080/contacts/".concat(contact.id), {
		method: "DELETE"
	})
	.then(
	window.location.reload()
	);
}
function createContactList(contacts) {
	const addressBook = document.createElement('div');
	addressBook.classList.add("addressBook");
	for (let i = 0; i < contacts.length; i++){
		const contact = document.createElement('p');
		
		contact.appendChild(createUserUUIDApi(contacts[i]));
		contact.appendChild(createUserFirstNameApi(contacts[i]));
		contact.appendChild(createUserLastNameApi(contacts[i]));
		contact.appendChild(createUserAddressApi(contacts[i]));
		contact.appendChild(createPhoneNumberApi(contacts[i]));
		contact.appendChild(createDeleteButton(contacts[i]));
		contact.appendChild(createUpdateButton(contacts[i]));
		addressBook.appendChild(contact);
	}
	return addressBook;
}
function createDeleteButton(contact) {
	const deleteButton = document.createElement("button");
	deleteButton.innerHTML = "Delete";
	deleteButton.classList = "deletebtn";
	deleteButton.onclick = function () {deleteContact(contact)};
	return deleteButton;
}
function createUpdateButton(contact) {
	const updateButton = document.createElement("button");
	updateButton.innerHTML = "Update";
	updateButton.classList = "updatebtn";
	updateButton.onclick = function () {updateContact(contact)};
	return updateButton;
}
function postUsersToApi(results) {
	for (let i = 0; i < results.length; i++){
		const contact = document.createElement('p');
		contact.classList.add("contact");
		contact.appendChild(createUserUUID(results[i]));
		contact.appendChild(createUserFirstName(results[i]));
		contact.appendChild(createUserLastName(results[i]));
//		contact.appendChild(createUserImage(results[i]));
		contact.appendChild(createUserAddress(results[i]));
		contact.appendChild(createPhoneNumber(results[i]));
		console.log(contact);
		postToServer(contact);	
	}
}
function createUserUUID(user){
	const id = document.createElement('h2');
	id.classList.add("id");
	id.textContent = `${user.login.uuid}`;
	return id;
}
function createPhoneNumber(user){
	const phoneNumber = document.createElement('h2');
	phoneNumber.classList.add("phoneNumber");
	phoneNumber.textContent = `${user.phone}`;
	return phoneNumber;
}
function createUserAddress(user) {
	const address = document.createElement('h2');
	address.classList.add("address");
	address.textContent = `${user.location.street.name} ${user.location.street.number}`;
	return address;
}
function createUserImage(user) {
	const img = document.createElement('img');
	img.src = `${user.picture.thumbnail}`;
	return img;
}
function createUserFirstName(user) {
	const firstName = document.createElement('h2');
	firstName.classList.add("firstName");
	firstName.textContent = `${user.name.first}`;
	return firstName;
}

function createUserLastName(user) {
	const lastName = document.createElement('h2');
	lastName.classList.add("lastName");
	lastName.textContent = `${user.name.last}`;
	return lastName;
}

function createUserUUIDApi(user){
	const id = document.createElement('h2');
	id.classList.add("id");
	id.textContent = `${user.id}`;
	return id;
}
function createPhoneNumberApi(user){
	const phoneNumber = document.createElement('h2');
	phoneNumber.classList.add("phoneNumber");
	phoneNumber.textContent = `${user.phoneNumber}`;
	return phoneNumber;
}
function createUserAddressApi(user) {

	const address = document.createElement('h2');
	address.classList.add("address");
	address.textContent = `${user.address}`;
	return address;
}
function createUserImageApi(user) {

	const img = document.createElement('img');
	img.src = `${user.picture.thumbnail}`;
	return img;
}
function createUserFirstNameApi(user) {
	const firstName = document.createElement('h2');
	firstName.classList.add("firstName");
	firstName.textContent = `${user.firstName}`;
	return firstName;
}
function createUserLastNameApi(user) {
	const lastName = document.createElement('h2');
	lastName.classList.add("lastName");
	lastName.textContent = `${user.lastName}`;
	return lastName;
}
document.addEventListener('DOMContentLoaded', () => {
	console.log("Document is loaded");
	const mainElement = document.querySelector("main");
	getApiUsers(mainElement);
});

const searchInput = document.querySelector("div.searchBar");
let map = [];
searchInput.addEventListener('input', (e) => {
	const value = e.target.value.toLowerCase();
	console.log(value);
	const contacts = document.querySelector("div.addressBook").children;
	map = Array.from(contacts);
	map.forEach(contact => {
		const searchMatch = contact.innerHTML.toLocaleLowerCase().includes(value);
		contact.classList.toggle("hide", !searchMatch);
	});
});
