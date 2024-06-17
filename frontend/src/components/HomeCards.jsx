import { Link } from 'react-router-dom';
import Card from './Card';

const HomeCards = () => {
  return (
    <section className='py-4'>
      <div className='container-xl lg:container m-auto'>
        <div className='grid grid-cols-1 md:grid-cols-2 gap-4 p-4 rounded-lg'>
          <Card>
            <h2 className='text-2xl font-bold'>For Developers</h2>
            <p className='mt-2 mb-4'>
              Browse our opportunities and find and jumpstart your career today
            </p>
            <Link
              to='/oportunities'
              className='inline-block bg-black text-white rounded-lg px-4 py-2 hover:bg-gray-700'
            >
              Browse Oportunities
            </Link>
          </Card>
          <Card bg='bg-indigo-100'>
            <h2 className='text-2xl font-bold'>For Employers</h2>
            <p className='mt-2 mb-4'>
              List your opportunity and find the perfect young leaders for the role
            </p>
            <Link
              to='/add-oportunity'
              className='inline-block bg-op-blue text-white rounded-lg px-4 py-2 hover:bg-op-aqua'
            >
              Add Opportunity
            </Link>
          </Card>
        </div>
      </div>
    </section>
  );
};
export default HomeCards;
