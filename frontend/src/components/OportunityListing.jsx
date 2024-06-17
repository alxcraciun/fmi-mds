import { useState } from 'react';
import { FaMapMarker } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const OportunityListing = ({ oportunity }) => {
  const [showFullDescription, setShowFullDescription] = useState(false);

  console.log(oportunity);
  let description = oportunity.description;

  if (!showFullDescription) {
    description = description.substring(0, 90) + '...';
  }

  return (
    <div className='bg-white rounded-xl shadow-md relative'>
      <div className='p-4'>
        <div className='mb-6'>
          <div className='text-gray-600 my-2'>{oportunity.type}</div>
          <h3 className='text-xl font-bold'>{oportunity.title}</h3>
        </div>

        <div className='mb-5'>{description}</div>

        <button
          onClick={() => setShowFullDescription((prevState) => !prevState)}
          className='text-op-blue mb-5 hover:text-op-aqua'
        >
          {showFullDescription ? 'Less' : 'More'}
        </button>

        <h3 className='text-op-blue mb-2'>{oportunity.salary} / Year</h3>

        <div className='border border-gray-100 mb-5'></div>

        <div className='flex flex-col lg:flex-row justify-between mb-4'>
          <div className='text-orange-700 mb-3'>
            <FaMapMarker className='inline text-lg mb-1 mr-1' />
            {oportunity.location}
          </div>
          <Link
            to={`/oportunities/${oportunity.id}`}
            className='h-[36px] bg-op-blue hover:bg-op-aqua text-white px-4 py-2 rounded-lg text-center text-sm'
          >
            Read More
          </Link>
        </div>
      </div>
    </div>
  );
};
export default OportunityListing;
