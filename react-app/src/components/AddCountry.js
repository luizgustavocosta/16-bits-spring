import React, { useContext } from 'react';
import CountryForm from './CountryForm';
import ContriesContext from '../context/ContriesContext';

const AddCountry = ({ history }) => {
    const { books, setBooks } = useContext(ContriesContext);

    const handleOnSubmit = (book) => {
        setBooks([book, ...books]);
        history.push('/');
    };

    return (
        <React.Fragment>
            <CountryForm handleOnSubmit={handleOnSubmit} />
        </React.Fragment>
    );
};

export default AddCountry;