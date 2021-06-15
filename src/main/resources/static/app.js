async function deleteById(e,id) {
    console.log(id);
    const res = await fetch('/customers/'+ id,{
        method: 'DELETE'
    });
    const data = await res.json();
    console.log(data);
    if (data) location.reload();
}