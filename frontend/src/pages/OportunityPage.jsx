import { useParams, useLoaderData, useNavigate } from 'react-router-dom';
import { FaArrowLeft, FaMapMarker } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';

const OportunityPage = ({ deleteOportunity }) => {
  const navigate = useNavigate();
  const { id } = useParams();
  const oportunity = useLoaderData();

  const onDeleteClick = (oportunityId) => {
    const confirm = window.confirm(
      'Are you sure you want to delete this listing?'
    );

    if (!confirm) return;

    deleteOportunity(oportunityId);

    toast.success('Oportunity deleted successfully');

    navigate('/oportunities');
  };

  return (
    <>
      <section>
        <div className='container m-auto py-6 px-6'>
          <Link
            to='/oportunities'
            className='text-op-blue hover:text-op-aqua flex items-center'
          >
            <FaArrowLeft className='mr-2' /> Back to opportunity listings
          </Link>
        </div>
      </section>

      <section className='bg-indigo-50'>
        <div className='container m-auto py-10 px-6'>
          <div className='grid grid-cols-1 md:grid-cols-70/30 w-full gap-6'>
            <main>
              <div className='bg-white p-6 rounded-lg shadow-md text-center md:text-left'>
                <div className='text-gray-500 mb-4'>{oportunity.type}</div>
                <h1 className='text-3xl font-bold mb-4'>{oportunity.title}</h1>
                <div className='text-gray-500 mb-4 flex align-middle justify-center md:justify-start'>
                  <FaMapMarker className='text-orange-700 mr-1' />
                  <p className='text-orange-700'>{oportunity.location}</p>
                </div>
              </div>

              <div className='bg-white p-6 rounded-lg shadow-md mt-6'>
                <h3 className='text-indigo-800 text-lg font-bold mb-6'>
                  Oportunity Description
                </h3>

                <p className='mb-4'>{oportunity.description}</p>

                <h3 className='text-indigo-800 text-lg font-bold mb-2'>
                  Salary
                </h3>

                <p className='mb-4'>{oportunity.salary} / Year</p>
              </div>
            </main>

            {/* <!-- Sidebar --> */}
            <aside>
              <div className='bg-white p-6 rounded-lg shadow-md'>
                <h3 className='text-xl font-bold mb-6'>Company Info</h3>
                
                <h2 className='text-2xl'>{oportunity.company.name}</h2>

                <p className='my-2'>{oportunity.company.description}</p>

                <hr className='my-4' />

                <h3 className='text-xl'>Contact Email:</h3>

                <p className='my-2 bg-indigo-100 p-2 font-bold'>
                  {oportunity.company.contactEmail}
                </p>

                <h3 className='text-xl'>Contact Phone:</h3>

                <p className='my-2 bg-indigo-100 p-2 font-bold'>
                  {' '}
                  {oportunity.company.contactPhone}
                </p>

                <Link
                  to={`/company/${oportunity.company.id}`}
                  className='bg-op-blue hover:bg-op-aqua text-white text-center font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block'
                >View Company Details
                </Link>
              </div>

              <div className='bg-white p-6 rounded-lg shadow-md mt-6'>
                <h3 className='text-xl font-bold mb-6'>Manage Oportunity</h3>
                <Link
                  to={`/edit-oportunity/${oportunity.id}`}
                  className='bg-op-blue hover:bg-op-aqua text-white text-center font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block'
                >
                  Edit Oportunity
                </Link>
                <button
                  onClick={() => onDeleteClick(oportunity.id)}
                  className='bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block'
                >
                  Delete Oportunity
                </button>
              </div>
            </aside>
          </div>
        </div>
      </section>
    </>
  );
};

const oportunityLoader = async ({ params }) => {
  const res = await fetch(`/api/oportunities/${params.id}`);
  const data = await res.json();
  return data;
};

export { OportunityPage as default, oportunityLoader };
