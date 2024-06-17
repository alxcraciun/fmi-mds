import Hero from '../components/Hero';
import HomeCards from '../components/HomeCards';
import OportunityListings from '../components/OportunityListings';
import ViewAllOportunities from '../components/ViewAllOportunities';

const HomePage = () => {
  return (
    <>
      <Hero />
      <HomeCards />
      <OportunityListings isHome={true} />
      <ViewAllOportunities />
    </>
  );
};
export default HomePage;
