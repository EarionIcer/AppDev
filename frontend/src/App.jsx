import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import SignupPage from "./pages/SignupPage";
import GuideListPage from "./pages/GuideListPage";
import FavoritesPage from "./pages/FavoritesPage";
import HotlinesPage from "./pages/HotlinesPage";
import ResourcesPage from "./pages/ResourcesPage";
import ProfilePage from "./pages/ProfilePage";
import Navbar from './pages/NavBar';
function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Pages WITHOUT navbar */}
        <Route path="/" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />

        {/* Pages WITH navbar */}
        <Route
          path="/app/*"
          element={
            <Navbar>
              <Route path="/guides" element={<GuideListPage />} />
              <Route path="/favorites" element={<FavoritesPage />} />
              <Route path="/hotlines" element={<HotlinesPage />} />
              <Route path="/resources" element={<ResourcesPage />} />
              <Route path="/profile" element={<ProfilePage />} />
            </Navbar>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}

export default App;

