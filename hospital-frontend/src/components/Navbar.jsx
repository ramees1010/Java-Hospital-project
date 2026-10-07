function Navbar() {
   const role=sessionStorage.getItem('role')
   const email=sessionStorage.getItem('email')
  sessionStorage.getItem('email')
  return (
    <header className="navbar">

      <div>
        <h2>Hospital Management System</h2>
      </div>

      <div className="profile">
        {email}
      </div>

    </header>
  )
}

export default Navbar;