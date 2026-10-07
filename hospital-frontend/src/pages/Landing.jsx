import { motion } from 'motion/react'
import { useNavigate } from 'react-router-dom'
import hospitalImage from '../assets/hospital-hero.png'

function Landing() {

  const navigate = useNavigate()

  return (
    <>

      <div className="landing">

        {/* Background hospital image */}
        <motion.div
          className="landing-background"
          style={{
            backgroundImage: `url(${hospitalImage})`
          }}
          initial={{ scale: 1.08 }}
          animate={{ scale: 1 }}
          transition={{
            duration: 2.5,
            ease: [0.22, 1, 0.36, 1]
          }}
        />

        {/* Dark cinematic overlay */}
        <div className="landing-overlay"></div>

        {/* Soft light effect */}
        <motion.div
          className="landing-glow"
          animate={{
            opacity: [0.15, 0.3, 0.15],
            scale: [1, 1.15, 1]
          }}
          transition={{
            duration: 6,
            repeat: Infinity,
            ease: "easeInOut"
          }}
        />

        {/* Navigation */}
        <motion.nav
          className="landing-nav"
          initial={{ opacity: 0, y: -30 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{
            duration: 0.8,
            delay: 0.3,
            ease: "easeOut"
          }}
        >

          <div className="landing-logo">
            <span className="logo-icon">✚</span>
            <span>MedCare</span>
          </div>

          <div className="landing-nav-links">

            <a href="#about">
              About
            </a>

            <button onClick={() => navigate('/login')}>
              Login
            </button>

          </div>

        </motion.nav>

        {/* Hero content */}
        <div className="landing-content">

          <motion.div
            className="hero-small-text"
            initial={{ opacity: 0, y: 25 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{
              duration: 0.8,
              delay: 0.7
            }}
          >
          </motion.div>

          <motion.h1
            initial={{ opacity: 0, y: 50 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{
              duration: 1,
              delay: 0.9,
              ease: [0.22, 1, 0.36, 1]
            }}
          >
            Your Health
            <br />

            <span>Our Priority</span>
          </motion.h1>

          <motion.p
            initial={{ opacity: 0, y: 35 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{
              duration: 0.8,
              delay: 1.2,
              ease: "easeOut"
            }}
          >
            Experience modern healthcare with trusted doctors,
            advanced facilities and seamless appointment management.
          </motion.p>

          <motion.div
            className="hero-buttons"
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{
              duration: 0.8,
              delay: 1.5
            }}
          >

            <motion.button
              className="primary-button"
              whileHover={{
                scale: 1.05,
                y: -3
              }}
              whileTap={{
                scale: 0.97
              }}
              onClick={() => navigate('/login')}
            >
              Book your Appointment
              <span>→</span>
            </motion.button>

          </motion.div>

        </div>

        {/* Bottom information */}
        <motion.div
          className="landing-bottom"
          initial={{ opacity: 0, y: 30 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{
            duration: 1,
            delay: 1.8
          }}
        >

          <div className="bottom-item">
            <strong>24/7</strong>
            <span>Emergency Care</span>
          </div>

          <div className="bottom-line"></div>

          <div className="bottom-item">
            <strong>50+</strong>
            <span>Specialist Doctors</span>
          </div>

          <div className="bottom-line"></div>

          <div className="bottom-item">
            <strong>10+</strong>
            <span>Departments</span>
          </div>

        </motion.div>

        {/* Scroll indicator */}
        <motion.div
          className="scroll-indicator"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{
            delay: 2.2,
            duration: 1
          }}
        >
        </motion.div>

      </div>


      {/* ABOUT SECTION */}

     <section id="about" className="about-section">

  <div className="about-container">

    {/* Top heading */}

    <motion.div
      className="about-heading"
      initial={{ opacity: 0, y: 40 }}
      whileInView={{ opacity: 1, y: 0 }}
      viewport={{ once: true }}
      transition={{ duration: 0.8 }}
    >

      <span className="about-label">
        ABOUT MEDICARE
      </span>

      <h2>
        Healthcare is
        <span> becoming digital.</span>
      </h2>

      <p>
        MediCare brings patients, doctors and healthcare services
        together through one simple digital experience.
      </p>

    </motion.div>


    {/* Main About Card */}

    <motion.div
      className="about-main-card"
      initial={{ opacity: 0, y: 50 }}
      whileInView={{ opacity: 1, y: 0 }}
      viewport={{ once: true }}
      transition={{ duration: 0.9 }}
    >

      <div className="about-main-content">

        <span className="about-small-label">
          THE FUTURE OF HEALTHCARE
        </span>

        <h3>
          One platform.
          <br />
          <span>Everything connected.</span>
        </h3>

        <p>
          From discovering doctors to managing appointments,
          medical records and prescriptions, MediCare is designed
          to make healthcare simpler, faster and more accessible.
        </p>

      </div>


      <div className="about-circle">

        <div className="circle-center">
          <span>✚</span>
          <small>MEDICARE</small>
        </div>

        <div className="orbit orbit-one">
          <span>Appointments</span>
        </div>

        <div className="orbit orbit-two">
          <span>Doctors</span>
        </div>

        <div className="orbit orbit-three">
          <span>Records</span>
        </div>

      </div>

    </motion.div>


    {/* Statistics */}

    <div className="about-stats">

      <motion.div
        className="about-stat"
        initial={{ opacity: 0, y: 30 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ delay: 0.1 }}
      >
        <strong>24/7</strong>
        <span>Healthcare Access</span>
      </motion.div>


      <motion.div
        className="about-stat"
        initial={{ opacity: 0, y: 30 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ delay: 0.2 }}
      >
        <strong>100%</strong>
        <span>Digital Experience</span>
      </motion.div>


      <motion.div
        className="about-stat"
        initial={{ opacity: 0, y: 30 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ delay: 0.3 }}
      >
        <strong>1</strong>
        <span>Connected Platform</span>
      </motion.div>


      <motion.div
        className="about-stat"
        initial={{ opacity: 0, y: 30 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
        transition={{ delay: 0.4 }}
      >
        <strong>∞</strong>
        <span>Possibilities</span>
      </motion.div>

    </div>


    {/* Vision */}

    <motion.div
      className="about-vision-modern"
      initial={{ opacity: 0, y: 40 }}
      whileInView={{ opacity: 1, y: 0 }}
      viewport={{ once: true }}
      transition={{ duration: 0.8 }}
    >

      <div>

        <span className="about-label">
          OUR VISION
        </span>

        <h3>
          Making healthcare
          <span> feel effortless.</span>
        </h3>

      </div>

      <p>
        We believe healthcare should not feel complicated.
        MediCare aims to create a connected digital ecosystem
        where getting the right healthcare is as simple as
        opening an app.
      </p>

    </motion.div>

  </div>

</section>

    </>
  )
}

export default Landing