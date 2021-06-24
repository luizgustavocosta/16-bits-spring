import React, { useContext } from 'react';
import _ from 'lodash';
import Country from './Country';
import ContriesContext from '../context/ContriesContext';

const ContryList = () => {
    const { books, setBooks } = useContext(ContriesContext);

    const handleRemoveBook = (id) => {
        setBooks(books.filter((book) => book.id !== id));
    };

    return (
        <React.Fragment>
            <div className="book-list">
                {!_.isEmpty(books) ? (
                    books.map((book) => (
                        <Country key={book.id} {...book} handleRemoveBook={handleRemoveBook} />
                    ))
                ) : (
                    <p className="message">No books available. Please add some books.</p>
                )}
            </div>
        </React.Fragment>
    );
};

export default ContryList;