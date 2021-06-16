async function deleteById(e,id) {
    console.log(id);
    const res = await fetch('/api/customers/'+ id,{
        method: 'DELETE'
    });
    const data = await res.json();
    console.log(data);
    if (data) location.reload();
}

async function updateById(e,id) {
    e.preventDefault();
    const formData = {
        name: document.querySelector('input[name="name"]').value,
        age: document.querySelector('input[name="age"]').value,
        address: document.querySelector('input[name="address"]').value,
        date: document.querySelector('input[type="date"]').value,
    }
    const res = await fetch('/api/customers/'+ id,{
        method: 'PUT',
        headers: {
        "Content-Type": "application/json",
        },
        body: JSON.stringify(formData)
    });
    const data = await res.json();
    console.log('Records updated: ', data);
    if (data) location.replace('/hello');
}

