import React from "react";
import {
  AppBar,
  Toolbar,
  Box,
  Typography,
  Button,
  IconButton,
  TextField,
  InputAdornment,
  Avatar,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import "./NavBar.css";

export default function Navbar() {
  return (
    <AppBar position="fixed" className="navbar">
      <Toolbar className="navbar-toolbar">

        {/* Logo */}
        <Box className="navbar-logo">
          <img src="/images/logo.png" alt="LifeLine" />
          <Typography className="navbar-title">LifeLine</Typography>
        </Box>

        {/* Nav Links */}
        <Box className="navbar-links">
          <Button className="nav-btn">Guides</Button>
          <Button className="nav-btn active">Favorites</Button>
          <Button className="nav-btn">Hotlines</Button>
          <Button className="nav-btn">Resources</Button>
        </Box>

        {/* Search */}
        <Box className="navbar-search">
          <TextField
            placeholder="Search guides..."
            size="small"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">
                  <SearchIcon fontSize="small" />
                </InputAdornment>
              ),
            }}
            className="search-field"
          />
        </Box>

        {/* Profile Icon */}
        <IconButton>
          <Avatar className="navbar-avatar">
            <Typography fontSize="1rem">👤</Typography>
          </Avatar>
        </IconButton>

      </Toolbar>
    </AppBar>
  );
}
