import React, { useContext } from 'react';
import CountryForm from './CountryForm';
import { useParams } from 'react-router-dom';
import ContriesContext from '../context/ContriesContext';

const EditCountry = ({ history }) => {
    const { books, setBooks } = useContext(ContriesContext);
    const { id } = useParams();
    const bookToEdit = books.find((book) => book.id === id);

    const handleOnSubmit = (book) => {
        const filteredBooks = books.filter((book) => book.id !== id);
        setBooks([book, ...filteredBooks]);
        history.push('/');
    };

    return (
        <div>
            <CountryForm book={bookToEdit} handleOnSubmit={handleOnSubmit} />
        </div>
    );
};

export default EditCountry;