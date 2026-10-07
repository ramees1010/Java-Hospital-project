import { useEffect, useState } from 'react'
import API_URL from '../services/Api'

function Prescriptions() {
  
    const role = sessionStorage.getItem('role')

  const [prescriptions, setPrescriptions] = useState([])
  const [showForm, setShowForm] = useState(false)

  const [medicine, setMedicine] = useState('')
  const [dosage, setDosage] = useState('')
  const [instruction, setInstruction] = useState('')
  const [medicalRecordId, setMedicalRecordId] = useState('')

  const loadPrescriptions = () => {

    fetch(`${API_URL}/prescriptions`,{
          credentials: 'include'
    })
      .then(response => response.json())
      .then(data => {
        setPrescriptions(data)
      })
      .catch(error => console.log(error))

  }

  useEffect(() => {
    loadPrescriptions()
  }, [])

  const addPrescription = () => {

    const prescription = {
      medicine: medicine,
      dosage: dosage,
      instruction: instruction,

      medicalRecord: {
        recordId: Number(medicalRecordId)
      }
    }

    fetch(`${API_URL}/prescriptions/add`, {
      method: 'POST',
       credentials: 'include',

      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(prescription)
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to add prescription')
        }

        alert('Prescription added')

        setMedicine('')
        setDosage('')
        setInstruction('')
        setMedicalRecordId('')
        setShowForm(false)

        loadPrescriptions()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>Prescriptions</h1>
         {(role === 'ROLE_ADMIN' || role === 'ROLE_DOCTOR') && (
        <button onClick={() => setShowForm(true)}>
          Add Prescription
        </button>
         )}
      </div>

      {showForm && (

        <div className="form-box">

          <h3>Add Prescription</h3>

          <input
            type="text"
            placeholder="Medicine"
            value={medicine}
            onChange={(e) =>
              setMedicine(e.target.value)
            }
          />

          <input
            type="text"
            placeholder="Dosage"
            value={dosage}
            onChange={(e) =>
              setDosage(e.target.value)
            }
          />

          <input
            type="text"
            placeholder="Instruction"
            value={instruction}
            onChange={(e) =>
              setInstruction(e.target.value)
            }
          />

          <input
            type="number"
            placeholder="Medical Record ID"
            value={medicalRecordId}
            onChange={(e) =>
              setMedicalRecordId(e.target.value)
            }
          />

          <button onClick={addPrescription}>
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
            <th>Medicine</th>
            <th>Dosage</th>
            <th>Instruction</th>
            <th>Medical Record</th>
          </tr>

        </thead>

        <tbody>

          {prescriptions.map(prescription => (

            <tr key={prescription.prescId}>

              <td>
                {prescription.prescId}
              </td>

              <td>
                {prescription.medicine}
              </td>

              <td>
                {prescription.dosage}
              </td>

              <td>
                {prescription.instruction}
              </td>

              <td>
                {prescription.medicalRecord?.recordId}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default Prescriptions