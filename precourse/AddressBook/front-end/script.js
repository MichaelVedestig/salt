const contactTemplate = document.querySelector("[data-user-template")




fetch("https://randomuser.me/api/?gender=female&results=30")
.then(res => res.json())
.then(data =>  {
	data.forEa
	const contact = contactTemplate.content.cloneNode(true).children[0]
	console.log(contact)
})
})