import {
  Route,
  createBrowserRouter,
  createRoutesFromElements,
  RouterProvider,
} from 'react-router-dom';
import MainLayout from './layouts/MainLayout';
import HomePage from './pages/HomePage';
import OportunitiesPage from './pages/OportunitiesPage';
import NotFoundPage from './pages/NotFoundPage';
import OportunityPage, { oportunityLoader } from './pages/OportunityPage';
import AddOportunityPage from './pages/AddOportunityPage';
import EditOportunityPage from './pages/EditOportunityPage';

const App = () => {
  // Add New Oportunity
  const addOportunity = async (newOportunity) => {
    const res = await fetch('/api/oportunities', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newOportunity),
    });
    return;
  };

  // Delete Oportunity
  const deleteOportunity = async (id) => {
    const res = await fetch(`/api/oportunities/${id}`, {
      method: 'DELETE',
    });
    return;
  };

  // Update Oportunity
  const updateOportunity = async (oportunity) => {
    const res = await fetch(`/api/oportunities/${oportunity.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(oportunity),
    });
    return;
  };

  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout />}>
        <Route index element={<HomePage />} />
        <Route path='/oportunities' element={<OportunitiesPage />} />
        <Route path='/add-oportunity' element={<AddOportunityPage addOportunitySubmit={addOportunity} />} />
        <Route
          path='/edit-oportunity/:id'
          element={<EditOportunityPage updateOportunitySubmit={updateOportunity} />}
          loader={oportunityLoader}
        />
        <Route
          path='/oportunities/:id'
          element={<OportunityPage deleteOportunity={deleteOportunity} />}
          loader={oportunityLoader}
        />
        <Route path='*' element={<NotFoundPage />} />
      </Route>
    )
  );

  return <RouterProvider router={router} />;
};
export default App;
