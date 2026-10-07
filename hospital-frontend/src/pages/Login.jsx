import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function Login() {

  const navigate = useNavigate()

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')

  const handleLogin = async (e) => {

    e.preventDefault()

    setError('')

    try {

      const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          email: email,
          password: password
        })
      })

      if (!response.ok) {
        throw new Error('Invalid email or password')
      }

      const data = await response.json()

      sessionStorage.clear()

      sessionStorage.setItem('loggedIn', 'true')
      sessionStorage.setItem('email', data.email)
      sessionStorage.setItem('role', data.role)

      if (data.role === 'ROLE_ADMIN') {
        navigate('/dashboard')
      }
      else if (data.role === 'ROLE_PATIENT') {
        navigate('/patients')
      }
      else if (data.role === 'ROLE_DOCTOR') {
        navigate('/appointments')
      }

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
          Welcome Back
        </h1>

        <p className="login-subtitle">
          Log in to your account
        </p>

        <form
          className="login-form"
          onSubmit={handleLogin}
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

          {error && (

            <div className="login-error">
              {error}
            </div>

          )}

          <button
            type="submit"
            className="login-button"
          >
            LogIn
            <span>→</span>
          </button>

        </form>


        <button
          type="button"
          className="back-home"
          onClick={() => navigate('/')}
        >
          Back
          <span></span>
        </button>
      <p className="signup-login-text">
  Don't have an account?
</p>

      <button
      type="button"
      className="back-button"
      onClick={() => navigate('/signup')}
      >
     Sign Up
    </button>
      </div>
     
    </div>
  )
}

export default Login