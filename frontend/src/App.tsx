import { useState } from "react";
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'
import CustomSearch from "./CustomSearch";

import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

import {
  AppBar,
  Container,
  CssBaseline,
  Toolbar,
  Typography,
} from "@mui/material";

function App() {
  return (
    <>
      <LocalizationProvider dateAdapter={AdapterDayjs}>
        <Container maxWidth="xl">
          <CssBaseline />
          <AppBar position="static">
            <Toolbar>
              <Typography variant="h6">ATA-IT bank</Typography>
            </Toolbar>
          </AppBar>
          <CustomSearch />
        </Container>
      </LocalizationProvider>
    </>
  );
}

export default App;
