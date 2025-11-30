import React, { useState } from "react";
import {
  Box,
  TextField,
  Button,
  MenuItem,
  InputAdornment,
  IconButton,
  Paper,
  Typography,
} from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import "./SignupPage.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function SignUp() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    dob: "",
    email: "",
    address: "",
    bloodType: "",
    allergies: "",
    username: "",
    password: "",
    confirmPassword: "",
  });

  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
  e.preventDefault();

  if (formData.password !== formData.confirmPassword) {
    alert("Passwords do not match");
    return;
  }

  try {
    const response = await axios.post("http://localhost:8080/api/users", {
      firstName: formData.firstName,
      lastName: formData.lastName,
      dob: formData.dob,
      email: formData.email,
      address: formData.address,
      bloodType: formData.bloodType,
      allergies: formData.allergies,
      username: formData.username,
      password: formData.password
    });

    console.log("User created:", response.data);

    alert("Account created successfully!");
    navigate("/"); // redirect to Login page

  } catch (error) {
    console.error(error);
    alert("Registration failed");
  }
};


  return (
    <Box className="signup-wrapper">
      <Paper className="signup-card" elevation={6}>
        <Box className="logo-container">
          <img src="/images/logo.png" alt="LifeLine Logo" className="logo-img" />
        </Box>
        <Typography variant="h5" className="signup-title">
          Sign Up
        </Typography>
        <form onSubmit={handleSubmit} className="signup-form">
          <TextField
            fullWidth
            label="First Name"
            variant="outlined"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="Last Name"
            variant="outlined"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="MM/DD/YYYY"
            variant="outlined"
            name="dob"
            value={formData.dob}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="Email"
            variant="outlined"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="Address"
            variant="outlined"
            name="address"
            value={formData.address}
            onChange={handleChange}
          />
          <TextField
            select
            fullWidth
            label="Blood Type"
            variant="outlined"
            name="bloodType"
            value={formData.bloodType}
            onChange={handleChange}
          >
            {["A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"].map((type) => (
              <MenuItem key={type} value={type}>
                {type}
              </MenuItem>
            ))}
          </TextField>
          <TextField
            fullWidth
            label="Allergies"
            variant="outlined"
            name="allergies"
            value={formData.allergies}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="Username"
            variant="outlined"
            name="username"
            value={formData.username}
            onChange={handleChange}
          />
          <TextField
            fullWidth
            label="Password"
            variant="outlined"
            type={showPassword ? "text" : "password"}
            name="password"
            value={formData.password}
            onChange={handleChange}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    onClick={() => setShowPassword(!showPassword)}
                    onMouseDown={(e) => e.preventDefault()}
                    edge="end"
                  >
                    {showPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
          <TextField
            fullWidth
            label="Confirm Password"
            variant="outlined"
            type={showConfirmPassword ? "text" : "password"}
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                    onMouseDown={(e) => e.preventDefault()}
                    edge="end"
                  >
                    {showConfirmPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              ),
            }}
          />
          <Button fullWidth type="submit" className="signup-btn">
            Create Account
          </Button>
        </form>
        <Typography className="signin-text">
          Already have an account?{" "}
          <span
            className="signin-link"
            onClick={() => navigate("/")}
            style={{ cursor: "pointer" }}
          >
            Sign In
          </span>
        </Typography>

      </Paper>
    </Box>
  );
}
