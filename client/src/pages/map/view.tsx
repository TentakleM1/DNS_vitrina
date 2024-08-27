import React from "react";
import {useNavigate} from "react-router-dom";

const fetchPost = async (data: Record<string, string>, endpoint: string) => {
    try {
        const response = await fetch(`http://localhost:9090/${endpoint}`, {
            method: "post",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error(`Error! status: ${response.status}`);
        }

        return await response.json();

    } catch (error) {
        throw new Error(`Error: not workig GET: ${error}`);
    }
};

const fetchGet = async () => {
    try {
        const response = await fetch("http://localhost:9090/users");

        if (!response.ok) {
            throw new Error(`Error! status: ${response.status}`);
        }

        const result = await response.json();
        console.log('get users:',result);

    } catch (error) {
        throw new Error(`Error: not workig GET: ${error}`);
    }
};

export const Map: React.FC = () => {
    const navigate = useNavigate();
    const getUsers = () => {
        fetchGet()
    }

    const loguout = () => {
        fetchPost({logout: 'logout'}, 'logout')
        navigate('/')
    }

    return (
        <div>
            <button onClick={() => {
                navigate('/create-user')
            }}>
                create user
            </button>
            <button onClick={getUsers}>
                get table users
            </button>
            <button onClick={loguout}>
                logout
            </button>
        </div>
    )
}