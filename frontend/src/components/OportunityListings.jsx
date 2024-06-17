import { useState, useEffect } from 'react';
import OportunityListing from './OportunityListing';
import Spinner from './Spinner';

const OportunityListings = ({ isHome = false }) => {
  const [oportunities, setOportunities] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchOportunities = async () => {
      const apiUrl = isHome ? '/api/oportunities?_limit=3' : '/api/oportunities';
      try {
        const res = await fetch(apiUrl);
        const data = await res.json();
        setOportunities(data);
      } catch (error) {
        console.log('Error fetching data', error);
      } finally {
        setLoading(false);
      }
    };

    fetchOportunities();
  }, []);

  return (
    <section className='bg-blue-50 px-4 py-10'>
      <div className='container-xl lg:container m-auto'>
        <h2 className='text-3xl font-bold text-op-blue mb-6 text-center'>
          {isHome ? 'Recent Oportunities' : 'Browse Oportunities'}
        </h2>

        {loading ? (
          <Spinner loading={loading} />
        ) : (
          <div className='grid grid-cols-1 md:grid-cols-3 gap-6'>
            {oportunities.map((oportunity) => (
              <OportunityListing key={oportunity.id} oportunity={oportunity} />
            ))}
          </div>
        )}
      </div>
    </section>
  );
};
export default OportunityListings;
