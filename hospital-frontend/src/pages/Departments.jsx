import { useEffect, useState } from 'react'
import API_URL from '../services/Api'

function Departments() {

  const [departments, setDepartments] = useState([])
  const [showForm, setShowForm] = useState(false)
  const [deptname, setDeptname] = useState('')

  const loadDepartments = () => {

    fetch(`${API_URL}/departments`,{
     credentials:'include'
    })
      .then(response => response.json())
      .then(data => {
        setDepartments(data)
      })
      .catch(error => {
        console.log(error)
      })

  }

  useEffect(() => {
    loadDepartments()
  }, [])

  const addDepartment = () => {

    if (deptname.trim() === '') {
      alert('Enter department name')
      return
    }
    
    fetch(`${API_URL}/departments/add`, {
      method: 'POST',
      credentials: 'include',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        deptname: deptname
      })
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to add department')
        }

        alert('Department added successfully')

        setDeptname('')
        setShowForm(false)

        loadDepartments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const updateDepartment = (id) => {

    fetch(`${API_URL}/departments/update/${id}`, {
      method: 'PUT',
     credentials: 'include',

    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to update department')
        }

        alert('Department updated')

        loadDepartments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const deleteDepartment = (id) => {

    if (!window.confirm('Delete this department?')) {
      return
    }

    fetch(`${API_URL}/departments/delete/${id}`, {
      method: 'DELETE'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to delete department')
        }

        alert('Department deleted')

        loadDepartments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>Departments</h1>

        <button onClick={() => setShowForm(true)}>
          Add Department
        </button>

      </div>

      {showForm && (

        <div className="form-box">

          <h3>Add Department</h3>

          <input
            type="text"
            placeholder="Department name"
            value={deptname}
            onChange={(e) => setDeptname(e.target.value)}
          />

          <button onClick={addDepartment}>
            Save
          </button>

          <button
            className="cancel-button"
            onClick={() => setShowForm(false)}
          >
            Cancel
          </button>

        </div>

      )}

      <table>

        <thead>
          <tr>
            <th>ID</th>
            <th>Department Name</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>

          {departments.map(department => (

            <tr key={department.deptId}>

              <td>
                {department.deptId}
              </td>

              <td>
                {department.deptname}
              </td>

              <td>

                <button
                  onClick={() =>
                    updateDepartment(department.deptId)
                  }
                >
                  Update
                </button>

                <button
                  className="delete-button"
                  onClick={() =>
                    deleteDepartment(department.deptId)
                  }
                >
                  Delete
                </button>

              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default Departments