import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import API_URL from '../services/Api'

function Signup() {

  const navigate = useNavigate()

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const [error, setError] = useState('')

  const handleSignup = async (e) => {

    e.preventDefault()

    setError('')

    if (password !== confirmPassword) {
      setError('Passwords do not match')
      return
    }

    try {

      const response = await fetch(`${API_URL}/auth/register`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          email: email,
          password: password
        })
      })

      const data = await response.json()

      if (!response.ok) {
        throw new Error(
          data.message || 'Registration failed'
        )
      }

      alert('Registration successful')

      navigate('/login')

    } catch (error) {

      console.log(error)
      setError(error.message)

    }
  }

  return (
    <div className="login-page">

      <div className="login-card">

        <div className="login-logo">
          ✚
        </div>

        <h1>
          Create Account
        </h1>

        <p className="login-subtitle">
          Create your MediCare patient account
        </p>

        <form
          className="login-form"
          onSubmit={handleSignup}
        >

          <div className="input-group">

            <label>
              Email Address
            </label>

            <input
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) =>
                setEmail(e.target.value)
              }
              required
            />

          </div>

          <div className="input-group">

            <label>
              Password
            </label>

            <input
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) =>
                setPassword(e.target.value)
              }
              required
            />

          </div>

          <div className="input-group">

            <label>
              Confirm Password
            </label>

            <input
              type="password"
              placeholder="Confirm your password"
              value={confirmPassword}
              onChange={(e) =>
                setConfirmPassword(e.target.value)
              }
              required
            />

          </div>

          {error && (

            <div className="login-error">
              {error}
            </div>

          )}

          <button
            type="submit"
            className="login-button"
          >
            Create Account
            <span>→</span>
          </button>

        </form>

        <p className="signup-login-text">
          Already have an account?
        </p>

        <button
          type="button"
          className="back-button"
          onClick={() => navigate('/login')}
        >
          Login
        </button>

        <button
          type="button"
          className="back-home"
          onClick={() => navigate('/')}
        >
          Back
          <span></span>
        </button>

      </div>

    </div>
  )
}

export default Signup