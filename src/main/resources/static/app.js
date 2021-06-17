async function deleteById(e,id) {
    console.log(id);
    try {
        const res = await fetch('/api/customers/'+ id,{
            method: 'DELETE'
        });
        const data = await res.json();
        console.log(data);
        if (data) location.reload();
    } catch (err) {
        document.querySelector('#error-toast').style.display = 'block';
        window.setTimeout(function(){
          location.reload();
        }, 2200)
    }
}

async function updateById(e,id) {
    e.preventDefault();
    const formData = {
        name: document.querySelector('input[name="name"]').value,
        age: document.querySelector('input[name="age"]').value,
        address: document.querySelector('input[name="address"]').value,
        date: document.querySelector('input[type="date"]').value,
    }
    try {
        const res = await fetch('/api/customers/'+ id,{
            method: 'PUT',
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(formData)
        });
        const data = await res.json();
        if (data) {
            console.log('Records updated: ', data);
            document.querySelector('#update-toast').style.display = 'block';
            window.setTimeout(function(){
              location.replace('/hello');
            }, 2200);
        }
    } catch (err) {
        document.querySelector('#error-toast').style.display = 'block';
        window.setTimeout(function(){
            location.reload();
        }, 2200);
    }
}

