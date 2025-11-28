import React, { useState } from "react";
import {
  Box,
  TextField,
  Typography,
  Button,
  Checkbox,
  FormControlLabel,
  IconButton,
  Divider,
  Paper,
  InputAdornment
} from "@mui/material";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import "./LoginPage.css";
import { Link } from "react-router-dom";

export default function LoginPage() {
  const [showPassword, setShowPassword] = useState(false);
  const [password, setPassword] = useState("");

  return (
    <Box className="login-wrapper">
      <Box className="login-container">
        {/* LEFT SIDE */}
        <Box className="left-side">
          <Paper elevation={6} className="logo-circle">
            <img src="/images/logo.png" alt="LifeLine Logo" className="logo-img" />
          </Paper>
          <Typography className="left-title">Welcome Back</Typography>
          <Typography className="left-subtitle">
            Sign in to your account to continue your journey with LifeLine
          </Typography>
        </Box>

        {/* RIGHT SIDE */}
        <Paper elevation={10} className="login-card">
          <Typography variant="h4" fontWeight={800}>
            LOGIN
          </Typography>
          <Typography variant="body2" mt={1} mb={3}>
            Enter your credentials to access your account
          </Typography>

          {/* Email */}
          <TextField
            fullWidth
            label="Email or Username"
            variant="filled"
            InputProps={{ disableUnderline: true }}
            className="textfield-custom"
          />

          {/* Password */}
          <TextField
            fullWidth
            label="Password"
            variant="outlined" // <- switch to outlined
            type={showPassword ? "text" : "password"}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton
                    onMouseDown={(e) => e.preventDefault()} // prevents losing focus
                    onClick={() => setShowPassword(!showPassword)}
                    edge="end"
                  >
                    {showPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              ),
            }}
            className="textfield-custom textfield-password"
          />


          {/* Remember + Forgot */}
          <Box className="options-row">
            <FormControlLabel
              className="remember-label"
              control={<Checkbox sx={{ color: "#fff" }} />}
              label="Remember me"
            />
            <Typography className="forgot-text">Forgot password?</Typography>
          </Box>

          {/* Login Button */}
          <Button variant="contained" fullWidth className="login-btn">
            LOGIN
          </Button>

          <Divider className="divider" />

          <Typography className="create-row">
            Don’t have an account?{" "}
            <Link to="/signup" className="create-account">
              Create account
            </Link>
          </Typography>
        </Paper>
      </Box>
    </Box>
  );
}
