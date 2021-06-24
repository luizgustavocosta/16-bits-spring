import React, { useContext } from 'react';
import _ from 'lodash';
import Country from './Country';
import ContriesContext from '../context/ContriesContext';

const ContryList = () => {
    const { books, setBooks } = useContext(ContriesContext);

    const handleRemoveBook = (id) => {
        // fetch('http://jsonplaceholder.typicode.com/users')
        fetch('http://localhost:9090/api/v1/customers')
            .then(res => res.json())
            .then((data) => {
                console.log(data)
            })
            .catch(console.log)


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